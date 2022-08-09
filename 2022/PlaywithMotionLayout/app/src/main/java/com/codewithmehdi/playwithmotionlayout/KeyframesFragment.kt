package com.codewithmehdi.playwithmotionlayout

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.animation.addListener
import com.codewithmehdi.playwithmotionlayout.databinding.FragmentKeyframesBinding
import kotlin.random.Random
import kotlin.random.nextInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KeyframesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KeyframesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentKeyframesBinding

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

        binding = FragmentKeyframesBinding.inflate(layoutInflater, container, false)

        binding.apply{
            root.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)
            updateUi(binding, smartphone)

            smartphone.setOnClickListener {
                val scales = listOf(1.0f, 2f, 3f, 4f, 5f, 6f, 7f)
                val offsets = listOf(5f, 10f, 20f, 40f, 80f,
                    -5F, -10F, -20F,-40F, -80F)


                ObjectAnimator.ofFloat(smartphone, View.TRANSLATION_X, offsets[Random.nextInt(0,1_000_000) % offsets.size]).apply {
                    duration = 1000
                    addListener(object: AnimatorListener{

                        override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                            super.onAnimationStart(animation, isReverse)
                        }

                        override fun onAnimationStart(animation: Animator?) {
                        }

                        override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                            super.onAnimationEnd(animation, isReverse)
                        }

                        override fun onAnimationEnd(animation: Animator?) {
                            updateUi(binding, smartphone)
                        }

                        override fun onAnimationCancel(animation: Animator?) {
                        }

                        override fun onAnimationRepeat(animation: Animator?) {
                        }
                    })

                    start()
                }

            }


        }

        return binding.root

//        return inflater.inflate(R.layout.fragment_keyframes, container, false)
    }

    private fun updateUi(binding: FragmentKeyframesBinding, target: View) {

                val loc = intArrayOf(0,1)
                target.getLocationOnScreen(loc)
                binding.info.text = "(x,y) = (${target.x}, ${target.y})\n" +
                        "(width, height) = (${target.width}, ${target.height})\n"+
                        "(pivotX, pivotY) = (${target.pivotX}, ${target.pivotY})}\n" +
                        "location: ${loc[0]}, ${loc[1]}"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KeyframesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KeyframesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}