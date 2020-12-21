package io.erikrios.github.mylistview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import io.erikrios.github.mylistview.R
import io.erikrios.github.mylistview.databinding.ItemHeroBinding
import io.erikrios.github.mylistview.models.Hero

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()
    override fun getCount(): Int = heroes.size

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val binding = ItemHeroBinding.bind(view)

        internal fun bind(hero: Hero) {
            binding.tvName.text = hero.name
            binding.tvDescription.text = hero.description
            binding.imgPhoto.setImageResource(hero.photo)
        }
    }
}