package com.example.continua3.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.continua3.ApiService
import com.example.continua3.R
import com.example.continua3.ServiceGenerator
import com.example.continua3.adapter.ListAdapter
import com.example.continua3.adapter.MessageAdapter
import com.example.continua3.model.ListModel
import com.example.continua3.model.MessageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MessagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessagesFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_messages, container, false)
        val recyclerViewMess = view.findViewById<RecyclerView>(R.id.recycler_view_messages)
        recyclerViewMess.layoutManager = LinearLayoutManager(context)
        recyclerViewMess.setHasFixedSize(true)
        getProductData { mess : List<MessageModel> -> recyclerViewMess.adapter = MessageAdapter(mess) }


        return view
    }
    private fun getProductData(callback: (List<MessageModel> ) -> Unit){
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getMessages()
        call.enqueue(object : Callback<List<MessageModel>> {
            override fun onResponse(call: Call<List<MessageModel>>, response: Response<List<MessageModel>>) {
                val mess = response.body()
                return callback(mess!!)
            }

            override fun onFailure(call: Call<List<MessageModel>>, t: Throwable) {
                Log.d("MessageFragment", "Error: ${t.message}")
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MessagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


