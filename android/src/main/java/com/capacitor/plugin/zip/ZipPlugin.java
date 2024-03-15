package com.capacitor.plugin.zip;

import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.File;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.progress.ProgressMonitor;
import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;

@CapacitorPlugin(name = "Zip")
public class ZipPlugin extends Plugin {

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void unZip(PluginCall call) {

        String source = call.getString("source", "");
        String destination = call.getString("destination", "");
        Boolean overwrite = call.getBoolean("overwrite", true);
        String password = call.getString("password");

        if (source.contains("_capacitor_")) {
            source = source.replace("_capacitor_", "");
        }

        if (source.contains("file://")) {
            source = source.replace("file://", "");
        }

        if (destination.contains("_capacitor_")) {
            destination = destination.replace("_capacitor_", "");
        }

        if (destination.contains("file://")) {
            destination = destination.replace("file://", "");
        }

        File archive = new File(source);
        if (!archive.exists()) {
            call.reject("File does not exist, invalid archive path: " + archive.getAbsolutePath());
        }

        try {
            ZipFile zipFile = new ZipFile(archive);
            zipFile.setRunInThread(true);

            File d = new File(destination);

            if (!d.exists()) {
                d.mkdirs();
            }
            List<FileHeader> fileHeaders = zipFile.getFileHeaders();
            for (FileHeader header : fileHeaders) {
                if (header.isDirectory()) {
                    if (d.exists()) {
                        File f = new File(destination, header.getFileName());
                        f.mkdirs();
                        zipFile.extractFile(header, f.toString());
                    }
                }
            }
            ProgressMonitor monitor = zipFile.getProgressMonitor();
            int progress;
            JSObject statusObject = new JSObject();
            zipFile.extractAll(destination);
            while (monitor.getState() == ProgressMonitor.State.BUSY) {
                progress = monitor.getPercentDone();
                statusObject.put("status", "progressing");
                statusObject.put("progress", progress);
                statusObject.put("completed", false);
                call.resolve(statusObject);
            }

            ProgressMonitor.Result result = monitor.getResult();
            switch (result) {
                case SUCCESS:
                    JSObject object = new JSObject();
                    object.put("status", "completed");
                    object.put("completed", true);
                    object.put("progress", 100);
                    object.put("path", destination);
                    call.resolve(object);
                    break;
                case ERROR:
                    call.error(monitor.getException().getMessage());
                    break;
                case CANCELLED:
                    call.error("Cancelled");
            }
        } catch (ZipException e) {
            call.error(e.getMessage());
        }

    }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void zip(PluginCall call) {
        String source = call.getString("source", "");
        String destination = call.getString("destination", "");
        Boolean overwrite = call.getBoolean("overwrite", true);
        String password = call.getString("password");


        if (source.contains("_capacitor_")) {
            source = source.replace("_capacitor_", "");
        }

        if (source.contains("file://")) {
            source = source.replace("file://", "");
        }

        if (destination.contains("_capacitor_")) {
            destination = destination.replace("_capacitor_", "");
        }

        if (destination.contains("file://")) {
            destination = destination.replace("file://", "");
        }

        File folder = new File(source);
        File dest = new File(destination);
        int index = source.lastIndexOf('/');
        String fileName = source.substring(index + 1);

        Log.d("filename", fileName);

        if (!folder.exists()) {
            call.reject("Folder does not exist, invalid folder path: " + folder.getAbsolutePath());
        }

        if (overwrite && dest.exists()) {
            Boolean deleted = dest.delete();
        }

        try {
            ZipFile zipFile = new ZipFile(dest);
            zipFile.setRunInThread(true);
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(CompressionMethod.DEFLATE);
            parameters.setCompressionLevel(CompressionLevel.NORMAL);
            parameters.setFileNameInZip(fileName);

            if(folder.isFile()){
                zipFile.addFile(folder,parameters);
            } else if(folder.isDirectory()){
                zipFile.addFolder(folder, parameters);
            }


        } catch (ZipException e) {
            Log.d("ERROR", e.getMessage());
        }

    }
}