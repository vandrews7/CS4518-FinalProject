package com.example.cs4518_finalproject

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import androidx.lifecycle.Observer
import java.util.*

private const val REQUEST_PHOTO = 2

class PhotoFragment : Fragment(){

    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var photoBtn: ImageButton
    private lateinit var photoFile: File
    private lateinit var photo: Photo
    private lateinit var photoUri: Uri

    private val photoViewModel: PhotoViewModel by lazy {
        ViewModelProviders.of(this).get(PhotoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photos, container, false)

        photoRecyclerView = view.findViewById(R.id.photoRecyclerView)
        photoRecyclerView.layoutManager = GridLayoutManager (context, 3)
        photoBtn = view.findViewById(R.id.photoBtn) as ImageButton
        photoUri = Uri.EMPTY

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoViewModel.photoLiveData.observe(
            viewLifecycleOwner,
            Observer { photo ->
                photo?.let {
                    this.photo = photo
                    photoFile = photoViewModel.getPhotoFile(photo)
                    photoUri = FileProvider.getUriForFile(requireActivity(),
                        "com.example.cs4518_finalproject.fileprovider",
                        photoFile)
                    updateUI()
                }
            })
    }

    private fun updateUI() {
    }

    override fun onStart() {
        super.onStart()

        photoBtn.apply {
            val packageManager: PackageManager = requireActivity().packageManager
            val captureImage = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val resolveActivity: ResolveInfo? =
                packageManager.resolveActivity(captureImage,
                PackageManager.MATCH_DEFAULT_ONLY)

            setOnClickListener{
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)

                val cameraActivities: List<ResolveInfo> =
                    packageManager.queryIntentActivities(captureImage,
                    PackageManager.MATCH_DEFAULT_ONLY)

                for (cameraActivity in cameraActivities) {
                    requireActivity().grantUriPermission(
                        cameraActivity.activityInfo.packageName,
                        photoUri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                }

                startActivityForResult(captureImage, REQUEST_PHOTO)
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().revokeUriPermission(photoUri,
            Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
    }

    companion object{
        fun newInstance() = PhotoFragment()
    }
}