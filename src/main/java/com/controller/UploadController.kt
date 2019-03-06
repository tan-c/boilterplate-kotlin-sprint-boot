//package com.boot.controller
//
//import org.bytedeco.javacv.FrameGrabber
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.web.bind.annotation.*
//import org.springframework.web.multipart.MultipartFile
//import com.boot.service.ConverterService
//import com.boot.service.GifEncoderService
//import com.boot.service.VideoDecoderService
//import io.swagger.annotations.Api
//import io.swagger.annotations.ApiOperation
//
//import javax.inject.Inject
//import java.io.File
//import java.io.IOException
//import java.lang.invoke.MethodHandles
//import java.nio.file.Paths
//
//@RestController
//@Api(value = "Upload", tags = ["Upload"], description = "Upload Services")
//class UploadController {
//
//    @Value("\${multipart.location}")
//    private val location: String? = null
//
//    @Inject
//    private val converterService: ConverterService? = null
//
//    @Inject
//    private val gifEncoderService: GifEncoderService? = null
//
//    @Inject
//    private val videoDecoderService: VideoDecoderService? = null
//
//    //    @RequestMapping(
////        value = "/upload",
////        method = arrayOf(RequestMethod.POST),
////        produces = arrayOf(MediaType.IMAGE_GIF_VALUE)
////    )
//    @ApiOperation(value = "Upload", notes = "")
//    @PostMapping("/upload")
//
//    @Throws(IOException::class, FrameGrabber.Exception::class)
//    fun upload(
//        @RequestPart("file") file: MultipartFile,
//        @RequestParam("start") start: Int,
//        @RequestParam("end") end: Int,
//        @RequestParam("speed") speed: Int,
//        @RequestParam("repeat") repeat: Boolean
//    ): String {
//        val videoFile = File(
//            "$location/" + System
//                .currentTimeMillis() + ".mp4"
//        )
//        file.transferTo(videoFile)
//
//        log.info("Saved video file to {}", videoFile.absolutePath)
//
//        val output = Paths.get(location + "/gif/" + System.currentTimeMillis() + ".gif")
//
//        val frameGrabber = videoDecoderService!!.read(videoFile)
//        val gifEncoder = gifEncoderService!!.getGifEncoder(
//            repeat,
//            frameGrabber.frameRate.toFloat(), output
//        )
//        converterService!!.toAnimatedGif(frameGrabber, gifEncoder, start, end, speed)
//
//        log.info("Saved generated gif to {}", output.toString())
//
//        return output.fileName.toString()
//    }
//
//    companion object {
//        private val log = LoggerFactory.getLogger(
//            MethodHandles.lookup()
//                .lookupClass()
//        )
//    }
//}
