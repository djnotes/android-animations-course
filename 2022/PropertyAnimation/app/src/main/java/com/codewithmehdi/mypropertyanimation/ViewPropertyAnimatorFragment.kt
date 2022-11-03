package com.codewithmehdi.mypropertyanimation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codewithmehdi.mypropertyanimation.databinding.FragmentViewPropertyAnimatorBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ViewPropertyAnimatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewPropertyAnimatorFragment : Fragment() {
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
        return FragmentViewPropertyAnimatorBinding.inflate(layoutInflater).apply{
            cart.setOnClickListener {cart->
                cart.animate()
                    .setDuration(500)
                    .rotationBy(-45f)
                    .withEndAction {
                        cart.animate()
                            .setDuration(500)
                            .rotationBy(90f)
                            .withEndAction {
                                cart.animate()
                                    .setDuration(300)
                                    .rotationBy(-45f)
                                    .withEndAction{
                                        cart.animate()
                                            .setDuration(200)
                                            .scaleXBy(0.2f)
                                            .scaleYBy(0.2f)
                                        title.text = "Animation Finished..."
                                    }

                            }

                    }
                    .withStartAction {
                        title.text = "Animation Started..."
                        title.invalidate()
                    }
                    .start()
            }
        }.root
//        return inflater.inflate(R.layout.fragment_view_property_animator, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewPropertyAnimatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewPropertyAnimatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}