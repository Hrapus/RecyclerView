package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.PersonItemBinding

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    val personList = ArrayList<Person>()

    class PersonHolder(item:View):RecyclerView.ViewHolder(item) {
        val binding = PersonItemBinding.bind(item)

        fun bind(person: Person) = with(binding){
            im.setImageResource(person.imageId)
            tv.text = person.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent,false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun addPerson(person: Person){
        personList.add(person)
        notifyDataSetChanged()
    }
}