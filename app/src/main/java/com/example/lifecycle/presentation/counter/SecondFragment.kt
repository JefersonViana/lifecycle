package com.example.lifecycle.presentation.counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lifecycle.databinding.FragmentSecondBinding
import com.example.lifecycle.presentation.ViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // LINHA 27 E PARA USAR JUNTO COM A LINHA 42 SUBSTITUINDO A LINHA 28
    // private lateinit var viewModel: MainViewModel
    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ESSA LINHA USA COM A LINHA 27
        // viewModel = ViewModelProvider(activity as AppCompatActivity).get()

        viewModel.counter.observe(viewLifecycleOwner) {counter ->
            binding.counter.text = counter.toString()
        }

        binding.buttonSecond.setOnClickListener {
            viewModel.increment()
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}