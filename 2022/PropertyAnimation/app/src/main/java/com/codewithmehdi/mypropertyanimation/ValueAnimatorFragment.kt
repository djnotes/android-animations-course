package com.codewithmehdi.mypropertyanimation

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codewithmehdi.mypropertyanimation.databinding.FragmentValueAnimatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ValueAnimatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ValueAnimatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
//        return inflater.inflate(R.layout.fragment_value_animator, container, false)
        return FragmentValueAnimatorBinding.inflate(layoutInflater).apply{
            animateValue.setOnClickListener {
                ValueAnimator.ofInt(1, 200).apply {
                    duration = 3_000

                    //Add listener
                    addUpdateListener { animator ->
                        animateValue.text =
                            "${animator.currentPlayTime}: ${animator.animatedValue as Int}"
                    }
                    start()
                }
            }


            //Add click listener
            animateView.setOnClickListener {
                ValueAnimator.ofArgb(Color.YELLOW).apply{
                    duration = 500

                    addUpdateListener { animator->
                        root.setBackgroundColor(animator.animatedValue as Int)
                        root.invalidate()
                    }

                    start()
                }
            }
        }
            .root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValueAnimatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ValueAnimatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}