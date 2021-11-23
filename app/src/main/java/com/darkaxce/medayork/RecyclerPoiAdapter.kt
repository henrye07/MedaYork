package com.darkaxce.medayork
import com.darkaxce.medayork.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darkaxce.medayork.Poi
import com.squareup.picasso.Picasso


import androidx.annotation.NonNull






class RecyclerPoiAdapter(private val mContext: Context, mGerencia: ArrayList<Poi>?) :
    RecyclerView.Adapter<RecyclerPoiAdapter.MyViewHolder?>(), View.OnClickListener {
    private val mGerencia: ArrayList<Poi>
    private var listener: View.OnClickListener? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {

        val view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null, false)
        view.setOnClickListener(this)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, i: Int) {
        myViewHolder.txtNombre.setText(mGerencia[i].name)
        myViewHolder.txtRecaudo.setText(mGerencia[i].description_short)
    }

    override fun getItemCount(): Int {
        return mGerencia.size
    }

    fun setOnClickListener(listener: View.OnClickListener?) {
        this.listener = listener
    }

    override fun onClick(view: View) {
        if (listener != null) {
            listener!!.onClick(view)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtNombre: TextView
        var txtRecaudo: TextView
        var image: ImageView

        init {
            txtNombre = itemView.findViewById(R.id.idNombre)
            txtRecaudo = itemView.findViewById(R.id.idInfo)
            image = itemView.findViewById(R.id.idImagen)
        }
    }

    init {
        this.mGerencia = mGerencia as ArrayList<Poi>
    }
}