package com.example.star_japan

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.star_japan.databinding.ActivityMainBinding
import com.example.star_japan.databinding.FragmentHomeBinding
import java.util.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding: FragmentHomeBinding? = null
    private val viewBinding get() = binding!!
    private var param1: String? = null
    private var param2: String? = null
    private val test = Test()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = viewBinding.root
        setPaper(viewBinding)

        setFragmentResultListener("switchData"){
            _, bundle ->
            test.setChangeK(bundle.getString("switch").toString())
            setPaper(viewBinding)
        }

        viewBinding.firstButton.setOnClickListener{
            if(test.isCorrect(0)){
                viewBinding.firstButton.setBackgroundColor(Color.parseColor("#009100"))
            }
            else{
                showCorrectAns(viewBinding)
                viewBinding.firstButton.setBackgroundColor(Color.parseColor("#EA0000"))
            }
            Handler().postDelayed(Runnable {
                resetButton(viewBinding)
                setPaper(viewBinding)
            },1200);
        }
        viewBinding.secondButton.setOnClickListener{
            if(test.isCorrect(1)){
                viewBinding.secondButton.setBackgroundColor(Color.parseColor("#009100"))
            }
            else{
                showCorrectAns(viewBinding)
                viewBinding.secondButton.setBackgroundColor(Color.parseColor("#EA0000"))
            }
            Handler().postDelayed(Runnable {
                resetButton(viewBinding)
                setPaper(viewBinding)
            },1200);
        }
        viewBinding.thirdButton.setOnClickListener{
            if(test.isCorrect(2)){
                viewBinding.thirdButton.setBackgroundColor(Color.parseColor("#009100"))
            }
            else{
                showCorrectAns(viewBinding)
                viewBinding.thirdButton.setBackgroundColor(Color.parseColor("#EA0000"))
            }
            Handler().postDelayed(Runnable {
                resetButton(viewBinding)
                setPaper(viewBinding)
            },1200);
        }
        viewBinding.fouthButton.setOnClickListener{
            if(test.isCorrect(3)){
                viewBinding.fouthButton.setBackgroundColor(Color.parseColor("#009100"))
            }
            else{
                showCorrectAns(viewBinding)
                viewBinding.fouthButton.setBackgroundColor(Color.parseColor("#EA0000"))
            }
            Handler().postDelayed(Runnable {
                resetButton(viewBinding)
                setPaper(viewBinding)
            },1200);
        }
        return view
    }

    public fun setPaper(viewBinding: FragmentHomeBinding){
        test.updateQuestion()
        viewBinding.textView2.text = test.getQusetion()
        viewBinding.firstButton.text = test.getChoice(0)
        viewBinding.secondButton.text = test.getChoice(1)
        viewBinding.thirdButton.text = test.getChoice(2)
        viewBinding.fouthButton.text = test.getChoice(3)
    }

    public fun showCorrectAns(viewBinding: FragmentHomeBinding){
        when(test.getAnsNumber()){
            0 -> viewBinding.firstButton.setBackgroundColor(Color.parseColor("#009100"))
            1 -> viewBinding.secondButton.setBackgroundColor(Color.parseColor("#009100"))
            2 -> viewBinding.thirdButton.setBackgroundColor(Color.parseColor("#009100"))
            3 -> viewBinding.fouthButton.setBackgroundColor(Color.parseColor("#009100"))
            else -> resetButton(viewBinding)
        }
    }

    public fun resetButton(viewBinding: FragmentHomeBinding){
        viewBinding.firstButton.setBackgroundColor(Color.parseColor("#FFAF60"))
        viewBinding.secondButton.setBackgroundColor(Color.parseColor("#FFAF60"))
        viewBinding.thirdButton.setBackgroundColor(Color.parseColor("#FFAF60"))
        viewBinding.fouthButton.setBackgroundColor(Color.parseColor("#FFAF60"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

class Test(){
    private var _questionBankH: Array<String?> = arrayOf(
                                                        "あ","い","う","え","お",
                                                        "か","き","く","け","こ",
                                                        "さ","し","す","せ","そ",
                                                        "た","ち","つ","て","と",
                                                        "な","に","ぬ","ね","の",
                                                        "は","ひ","ふ","へ","ほ",
                                                        "ま","み","む","め","も",
                                                        "や","ゆ","よ",
                                                        "ら","り","る","れ","ろ",
                                                        "わ","を","ん")
    private var _questionBankK: Array<String?> = arrayOf(
                                                        "ア","イ","ウ","エ","オ",
                                                        "カ","キ","ク","ケ","コ",
                                                        "サ","シ","ス","セ","ソ",
                                                        "タ","チ","ツ","テ","ト",
                                                        "ナ","ニ","ヌ","ネ","ノ",
                                                        "ハ","ヒ","フ","ヘ","ホ",
                                                        "マ","ミ","ム","メ","モ",
                                                        "ヤ","ユ","ヨ",
                                                        "ラ","リ","ル","レ","ロ",
                                                        "ワ","ヲ","ン")
    private var _questionBankPinyin: Array<String?> = arrayOf(
                                                        "a","i","u","e","o",
                                                        "ka","ki","ku","ke","ko",
                                                        "sa","shi","su","se","so",
                                                        "ta","chi","tsu","te","to",
                                                        "na","ni","nu","ne","no",
                                                        "ha","hi","fu","he","ho",
                                                        "ma","mi","mu","me","mo",
                                                        "ya","yu","yo",
                                                        "ra","ri","ru","re","ro",
                                                        "wa","wo","n")
    private var _questionBankNumber: Int = 0
    private var _question: String = ""
    private val _choices: Array<String?> = arrayOfNulls<String>(4)
    private var _ansNumber: Int = 0
    private var _changeK: Boolean = false

    public fun getChangeK():String{
        return _changeK.toString()
    }
    public fun getQusetion(): String{
        return _question
    }
    public fun getChoice(index: Int): String? {
        return _choices[index]
    }
    public fun getAnsNumber(): Int{
        return _ansNumber
    }
    public fun getQuestionBank(): Array<String?>{
        if(_changeK)
            return _questionBankK
        else
            return _questionBankH
    }
    public fun setChangeK(data: String){
        _changeK = data.toBooleanStrict()
    }
    public fun updateQuestion(){
        val mode = (1..2).random()
        val correctAnsNumber = (_questionBankPinyin.indices).random()
        _ansNumber = (0 .. 3).random()

        if(mode == 1){ // 題目是 key，選項是 value
            _question = getQuestionBank()[correctAnsNumber].toString()
            _choices[_ansNumber] = _questionBankPinyin[correctAnsNumber]
        }
        else if(mode == 2){ // 題目是 value，選項是 key
            _choices[_ansNumber] = getQuestionBank()[correctAnsNumber]
            _question = _questionBankPinyin[correctAnsNumber].toString()
        }
        val otherChoice:Array<String?> = getOtherChoice(mode,correctAnsNumber)
        var count = 0
        for (i in 0..3){
            if(i == _ansNumber)
                continue
            _choices[i] = otherChoice[count]
            count++
        }
    }
    public fun getOtherChoice(mode: Int, correctAnsNumber: Int): Array<String?>{
        val otherChoice: Array<String?> = arrayOfNulls<String>(3)
        var count = 0
        while(count <= 2){
            var worngAnsNumber = (_questionBankPinyin.indices).random()
            var Flag = false
            for(i in otherChoice.indices){
                if(getQuestionBank()[worngAnsNumber]==otherChoice[i]||_questionBankPinyin[worngAnsNumber]==otherChoice[i])
                    Flag = true
            }
            if(Flag||worngAnsNumber==correctAnsNumber)
                continue
            if(mode==1){ // 題目是 key，選項是 value
                otherChoice[count] = _questionBankPinyin[worngAnsNumber]
            }
            else if(mode==2){ // 題目是 value，選項是 key
                otherChoice[count] = getQuestionBank()[worngAnsNumber]
            }
            count++
        }
        return otherChoice
    }
    public fun isCorrect(number: Int): Boolean{
        if(number==_ansNumber)
            return true
        return false
    }
}