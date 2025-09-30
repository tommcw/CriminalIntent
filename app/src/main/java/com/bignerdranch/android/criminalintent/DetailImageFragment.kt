package com.bignerdranch.android.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import java.io.File


class DetailImageFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_image, null)
        val imageView = view.findViewById<ImageView>(R.id.dialog_photo)
        val photoFileName = arguments?.getString("photoFileName")

        if (photoFileName != null) {
            val photoFile = File(requireContext().applicationContext.filesDir, photoFileName)
            if (photoFile.exists()) {
                val bitmap = BitmapFactory.decodeFile(photoFile.path)
                imageView.setImageBitmap(bitmap)
            }
        }
        builder.setView(view)
        return builder.create()
    }
}