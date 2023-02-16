package hong.sy.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hong.sy.lotto.databinding.ActivityConstellationBinding

class ConstellationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstellationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConstellationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButton()
    }

    private fun setButton() {
        binding.cardAries.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("양자리")))
            intent.putExtra("constellation", "양자리")
            startActivity(intent)
        }

        binding.cardTaurus.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("황소자리")))
            intent.putExtra("constellation", "황소자리")
            startActivity(intent)
        }

        binding.cardGemini.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("쌍둥이자리")))
            intent.putExtra("constellation", "쌍둥이자리")
            startActivity(intent)
        }

        binding.cardCancer.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("게자리")))
            intent.putExtra("constellation", "게자리")
            startActivity(intent)
        }

        binding.cardLeo.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("사자자리")))
            intent.putExtra("constellation", "사자자리")
            startActivity(intent)
        }

        binding.cardVirgo.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("처녀자리")))
            intent.putExtra("constellation", "처녀자리")
            startActivity(intent)
        }

        binding.cardLibra.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("천칭자리")))
            intent.putExtra("constellation", "천칭자리")
            startActivity(intent)
        }

        binding.cardScorpio.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("전갈자리")))
            intent.putExtra("constellation", "전갈자리")
            startActivity(intent)
        }

        binding.cardSagittarius.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("궁수자리")))
            intent.putExtra("constellation", "궁수자리")
            startActivity(intent)
        }

        binding.cardCapricorn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("염소자리")))
            intent.putExtra("constellation", "염소자리")
            startActivity(intent)
        }

        binding.cardAquarius.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("물병자리")))
            intent.putExtra("constellation", "물병자리")
            startActivity(intent)
        }

        binding.cardPisces.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash("물고기자리")))
            intent.putExtra("constellation", "물고기자리")
            startActivity(intent)
        }
    }
}