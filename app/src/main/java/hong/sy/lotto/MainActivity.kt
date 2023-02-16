package hong.sy.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import hong.sy.lotto.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        setUpdateText()
        setCardClick()
    }

    private fun setCardClick() {
        binding.cardPercent.setOnClickListener {
            getLottoNumberFromPercent()
        }

        binding.cardRandom.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            startActivity(intent)
        }

        binding.cardConstellation.setOnClickListener {
            val intent = Intent(this, ConstellationActivity::class.java)
            startActivity(intent)
        }

        binding.cardName.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getLottoNumberFromPercent() {
        val list = mutableListOf<Int>()
        val percent = mutableListOf<Int>()

        val database = Firebase.database
        val myRef = database.getReference("percent")
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for(numSnapshot in snapshot.children) {
                        val per = numSnapshot.getValue(Int::class.java)
                        if (per != null) {
                            percent.add(per)
                        }
                    }
                }
                val l = mutableListOf<Int>()

                for(i in 1..45) {
                    for(j in 1..percent[i-1]) {
                        l.add(i)
                    }
                }

                l.shuffle()

                for(i in 1..6) {
                    var number = 0

                    do {
                        number = l[Random().nextInt(l.size)]
                    } while(list.contains(number))

                    list.add(number)
                }

                startIntent(list)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun startIntent(list: MutableList<Int>) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", ArrayList(list))
        intent.putExtra("percent", "당첨 횟수")
        startActivity(intent)
    }

    public override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun signInAnnoymously() {
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInAnonymously:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Login", "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun setUpdateText() {
        val database = Firebase.database
        val myRef = database.getReference("update")
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    val date = snapshot.child("date").getValue(String::class.java)
                    val turn = snapshot.child("turn").getValue(Int::class.java)

                    if (date != null && turn != null) {
                        binding.tvUpdate.text = "업데이트 완료 : ${turn}회 (${date})"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}