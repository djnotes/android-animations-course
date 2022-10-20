package com.codewithmehdi.mypropertyanimation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codewithmehdi.mypropertyanimation.databinding.FragmentObjectAnimatorBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ObjectAnimatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObjectAnimatorFragment : Fragment() {
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
//        return inflater.inflate(R.layout.fragment_object_animator, container, false)
        return FragmentObjectAnimatorBinding.inflate(layoutInflater).apply{
            animateView.setOnClickListener {
                //TODO: Animate views using ObjectAnimator
                ObjectAnimator.ofFloat(title, "rotation", 0f, 360f).apply{
                duration = 500
                start()
              }

                ObjectAnimator.ofFloat(title, "alpha", 0f, 1f).apply{
                    duration = 500
                    start()
                }

                val rotationVH = PropertyValuesHolder.ofFloat("rotation", 0f, 360f)
                val alphaVH = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)

                ObjectAnimator.ofPropertyValuesHolder(plus, rotationVH, alphaVH).apply{
                    duration = 500
                    start()
                }




            }


        }.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ObjectAnimatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ObjectAnimatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}