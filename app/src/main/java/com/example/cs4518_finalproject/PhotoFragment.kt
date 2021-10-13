package com.example.cs4518_finalproject

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.util.*

private const val REQUEST_CODE = 200

class PhotoFragment : Fragment(){

    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var photoBtn: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photos, container, false)

        photoRecyclerView = view.findViewById(R.id.photoRecyclerView) //TODO finish from pg. 862
        photoRecyclerView.layoutManager = GridLayoutManager (context, 3)
        photoBtn = view.findViewById(R.id.photoBtn) as ImageButton

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

        photoBtn.apply {
            val packageManager: PackageManager = requireActivity().packageManager
            val captureImage = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val resolvedActivity: ResolveInfo? =
                packageManager.resolveActivity(captureImage,
                PackageManager.MATCH_DEFAULT_ONLY)

            setOnClickListener{
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, )
            }
        }
    }

    companion object{
        fun newInstance() = PhotoFragment()
    }
}