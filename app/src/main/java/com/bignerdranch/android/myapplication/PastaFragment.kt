package com.bignerdranch.android.myapplication
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
/**
 * A simple [Fragment] subclass.
 * Use the [PastaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PastaFragment : ListFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val adapter = ArrayAdapter<String>(inflater.context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.pasta))
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PastaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PastaFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}