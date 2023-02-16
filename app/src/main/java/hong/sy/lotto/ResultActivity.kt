package hong.sy.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import hong.sy.lotto.databinding.ActivityResultBinding
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("result") as MutableList<Int>
        val percent = intent.getStringExtra("percent")
        val constellation = intent.getStringExtra("constellation")
        val name = intent.getStringExtra("name")

        if(!TextUtils.isEmpty(percent)) {
            binding.tvResultTitle.text = "${percent}로 생성된\n로또번호입니다"
        } else if(!TextUtils.isEmpty(constellation)) {
            binding.tvResultTitle.text = "${constellation} 의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다"
        } else if(!TextUtils.isEmpty(name)) {
            binding.tvResultTitle.text = "${name} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호입니다"
        }

        result.let {
            updateLottoBall(result.sortedBy { it })
        }
    }

    private fun updateLottoBall(result: List<Int>) {
        if(result.size < 6) return

        for(i in 0..5) {
            updateLottoBallColor(i, result[i])

            when(i) {
                0 -> binding.tvNum1.text = result[i].toString()
                1 -> binding.tvNum2.text = result[i].toString()
                2 -> binding.tvNum3.text = result[i].toString()
                3 -> binding.tvNum4.text = result[i].toString()
                4 -> binding.tvNum5.text = result[i].toString()
                5 -> binding.tvNum6.text = result[i].toString()
            }
        }
    }

    private fun updateLottoBallColor(index: Int, num: Int) {
        when(num) {
            in 1..10 ->
                if(index == 0) {
                    binding.tvNum1.setBackgroundResource(R.drawable.yellow_circle)
                } else if(index == 1) {
                    binding.tvNum2.setBackgroundResource(R.drawable.yellow_circle)
                } else if(index == 2) {
                    binding.tvNum3.setBackgroundResource(R.drawable.yellow_circle)
                } else if(index == 3) {
                    binding.tvNum4.setBackgroundResource(R.drawable.yellow_circle)
                } else if(index == 4) {
                    binding.tvNum5.setBackgroundResource(R.drawable.yellow_circle)
                } else {
                    binding.tvNum6.setBackgroundResource(R.drawable.yellow_circle)
                }

            in 11..20 ->
                if(index == 0) {
                    binding.tvNum1.setBackgroundResource(R.drawable.blue_circle)
                } else if(index == 1) {
                    binding.tvNum2.setBackgroundResource(R.drawable.blue_circle)
                } else if(index == 2) {
                    binding.tvNum3.setBackgroundResource(R.drawable.blue_circle)
                } else if(index == 3) {
                    binding.tvNum4.setBackgroundResource(R.drawable.blue_circle)
                } else if(index == 4) {
                    binding.tvNum5.setBackgroundResource(R.drawable.blue_circle)
                } else {
                    binding.tvNum6.setBackgroundResource(R.drawable.blue_circle)
                }

            in 21..30 ->
                if(index == 0) {
                    binding.tvNum1.setBackgroundResource(R.drawable.red_circle)
                } else if(index == 1) {
                    binding.tvNum2.setBackgroundResource(R.drawable.red_circle)
                } else if(index == 2) {
                    binding.tvNum3.setBackgroundResource(R.drawable.red_circle)
                } else if(index == 3) {
                    binding.tvNum4.setBackgroundResource(R.drawable.red_circle)
                } else if(index == 4) {
                    binding.tvNum5.setBackgroundResource(R.drawable.red_circle)
                } else {
                    binding.tvNum6.setBackgroundResource(R.drawable.red_circle)
                }

            in 31..40 ->
                if(index == 0) {
                    binding.tvNum1.setBackgroundResource(R.drawable.gray_circle)
                } else if(index == 1) {
                    binding.tvNum2.setBackgroundResource(R.drawable.gray_circle)
                } else if(index == 2) {
                    binding.tvNum3.setBackgroundResource(R.drawable.gray_circle)
                } else if(index == 3) {
                    binding.tvNum4.setBackgroundResource(R.drawable.gray_circle)
                } else if(index == 4) {
                    binding.tvNum5.setBackgroundResource(R.drawable.gray_circle)
                } else {
                    binding.tvNum6.setBackgroundResource(R.drawable.gray_circle)
                }

            in 41..45 ->
                if(index == 0) {
                    binding.tvNum1.setBackgroundResource(R.drawable.green_circle)
                } else if(index == 1) {
                    binding.tvNum2.setBackgroundResource(R.drawable.green_circle)
                } else if(index == 2) {
                    binding.tvNum3.setBackgroundResource(R.drawable.green_circle)
                } else if(index == 3) {
                    binding.tvNum4.setBackgroundResource(R.drawable.green_circle)
                } else if(index == 4) {
                    binding.tvNum5.setBackgroundResource(R.drawable.green_circle)
                } else {
                    binding.tvNum6.setBackgroundResource(R.drawable.green_circle)
                }
        }
    }
}