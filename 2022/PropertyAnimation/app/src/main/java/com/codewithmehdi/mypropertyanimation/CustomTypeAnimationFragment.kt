package com.codewithmehdi.mypropertyanimation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.codewithmehdi.mypropertyanimation.databinding.FragmentCustomTypeAnimationBinding
import com.google.android.material.animation.AnimatorSetCompat
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomTypeAnimationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomTypeAnimationFragment : Fragment() {
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
//        return inflater.inflate(R.layout.fragment_custom_type_animation, container, false)
        return FragmentCustomTypeAnimationBinding.inflate(layoutInflater).apply{
            dog.setOnClickListener {
                ValueAnimator.ofObject(MyRectEvaluator(),
                    Rect(dog.left, dog.top, dog.right, dog.bottom),
                    Rect(Random.nextInt(100), Random.nextInt(200), Random.nextInt(500, 900), Random.nextInt(400, 1200))
                ).apply{
                    addUpdateListener {listener->
                        val r = listener.animatedValue as Rect
                        dog.left = r.left
                        dog.top = r.top
                        dog.right = r.right
                        dog.bottom = r.bottom
                    }
                    duration = 2000
                    start()
                }
            }
        }.root
    }

    class MyRectEvaluator: TypeEvaluator<Rect>{
        override fun evaluate(fraction: Float, startValue: Rect?, endValue: Rect?): Rect {
            startValue?.let{start->
                endValue?.let{end->
                    return Rect(
                        (start.left + (end.left - start.left) * fraction).toInt(),
                        (start.top + (end.top - start.top) * fraction).toInt(),
                        (start.right + (end.right - start.right) * fraction).toInt(),
                        (start.bottom + (end.bottom - start.bottom) * fraction).toInt()
                    )
                }
            }
            return startValue!!
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomTypeAnimation.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomTypeAnimationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}