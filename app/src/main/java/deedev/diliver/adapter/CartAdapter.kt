package deedev.diliver.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import deedev.diliver.databinding.CartItemBinding
import deedev.diliver.databinding.CartItemBinding.*

class CartAdapter(private val cartItems: List<String>, private val CartItemPrice: List<String>, private var CartImage: List<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

private val itemQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
    val binding= inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    if (itemQuantities[position] > 1) {
                        itemQuantities[position]--
                        cartItemQuantity.text = itemQuantities[position].toString()
                    }

                }
                plusButton.setOnClickListener {
                    itemQuantities[position]++
                    cartItemQuantity.text = itemQuantities[position].toString()

                }
                deleteItem.setOnClickListener {
                    cartItems.toMutableList().removeAt(position)
                    CartItemPrice.toMutableList().removeAt(position)
                    CartImage.toMutableList().removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, cartItems.size)
                }

            }
        }

    }

}