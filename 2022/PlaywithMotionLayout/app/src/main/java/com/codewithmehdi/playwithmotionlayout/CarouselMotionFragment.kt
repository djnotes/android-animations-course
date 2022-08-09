package com.codewithmehdi.playwithmotionlayout

import android.animation.Animator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.codewithmehdi.playwithmotionlayout.databinding.FragmentCarouselMotionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarouselMotionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarouselMotionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentCarouselMotionBinding

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

        binding = FragmentCarouselMotionBinding.inflate(layoutInflater, container, false)


        var colors = intArrayOf(
            Color.parseColor("#ffd54f"),
            Color.parseColor("#ffca28"),
            Color.parseColor("#ffc107"),
            Color.parseColor("#ffb300"),
            Color.parseColor("#ffa000"),
            Color.parseColor("#ff8f00"),
            Color.parseColor("#ff6f00"),
            Color.parseColor("#c43e00")
        )

        val views = listOf(
            binding.widgetA,
            binding.widgetB,
            binding.widgetC,
            binding.widgetD,
            binding.widgetE
        )

        val images = listOf(
            R.drawable.woman,
            R.drawable.man,
            R.drawable.tiger,
            R.drawable.bird,
            R.drawable.trashcan,
            R.drawable.garden,
            R.drawable.smartphone,
            R.drawable.phone,
            R.drawable.watermelon,
            R.drawable.profile,
            R.drawable.add,
            R.drawable.ic_shopping_cart

        )

        binding.apply{

            carousel.setAdapter(object: Carousel.Adapter{
                override fun count(): Int {
                    return images.size
                }

                override fun populate(view: View?, index: Int) {
                    if (view is ImageView)
                        view.setImageResource(images[index])
                }

                override fun onNewItem(index: Int) {

                }

            })
        }

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_carousel_motion, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarouselMotionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarouselMotionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}