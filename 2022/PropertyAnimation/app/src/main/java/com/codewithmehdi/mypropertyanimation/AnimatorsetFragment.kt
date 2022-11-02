package com.codewithmehdi.mypropertyanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codewithmehdi.mypropertyanimation.databinding.FragmentAnimatorsetBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimatorsetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimatorsetFragment : Fragment() {
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
        return FragmentAnimatorsetBinding.inflate(layoutInflater).apply{
            animateMultipleViews.setOnClickListener {
                val  titleAnim = ObjectAnimator.ofFloat(title, "rotation", 0f, 360f)
                val plusAnim = ObjectAnimator.ofFloat(plusImage, "scaleX", 1f, 2f)
                val buttonAnim = ObjectAnimator.ofArgb(animateView, "backgroundColor", Color.BLUE, Color.RED)
                AnimatorSet().apply{
//                    playTogether(
//                        titleAnim,
//                        plusAnim,
//                        buttonAnim
//                    )
//                    playSequentially(
//                        buttonAnim,
//                        plusAnim,
//                        titleAnim
//                    )

                    play(titleAnim)
                        .with(plusAnim)
                        .after(buttonAnim)

                    duration = 2000
                    start()
                }
            }
        }.root
//        return inflater.inflate(R.layout.fragment_animatorset, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnimatorsetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimatorsetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}