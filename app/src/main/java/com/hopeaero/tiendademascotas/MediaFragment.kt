package com.hopeaero.tiendademascotas

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class MediaFragment : Fragment() {

    private var mediaUrl: String? = null
    private var videoResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaUrl = arguments?.getString(ARG_MEDIA_URL)
        videoResId = arguments?.getInt(ARG_VIDEO_RES_ID, INVALID_RES_ID) // Use a default invalid value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frame_media, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val videoView = view.findViewById<VideoView>(R.id.videoView)

        if (videoResId != null && videoResId != INVALID_RES_ID) {
            // Show VideoView and hide ImageView
            imageView.visibility = View.GONE
            videoView.visibility = View.VISIBLE

            // Set up the video URI and start playback
            val videoUri = Uri.parse("android.resource://${requireContext().packageName}/${videoResId!!}")
            videoView.setVideoURI(videoUri)

            // Set an OnPreparedListener to start the video when it's ready
            videoView.setOnPreparedListener { mediaPlayer ->
                mediaPlayer.start()
            }

            // Handle errors
            videoView.setOnErrorListener { _, what, extra ->
                Log.e("MediaFragment", "Error playing video: what=$what, extra=$extra")
                false
            }
        } else {
            // Show ImageView and hide VideoView
            videoView.visibility = View.GONE
            imageView.visibility = View.VISIBLE

            // Load the image using Glide or any other image-loading library
            Glide.with(this).load(mediaUrl).into(imageView)
        }

        return view
    }

    companion object {
        private const val ARG_MEDIA_URL = "media_url"
        private const val ARG_VIDEO_RES_ID = "video_res_id"
        private const val INVALID_RES_ID = 0 // Use an invalid resource ID to represent null

        fun newInstance(mediaUrl: String?, videoResId: Int?) = MediaFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_MEDIA_URL, mediaUrl)
                putInt(ARG_VIDEO_RES_ID, videoResId ?: INVALID_RES_ID) // Use INVALID_RES_ID if videoResId is null
            }
        }
    }
}