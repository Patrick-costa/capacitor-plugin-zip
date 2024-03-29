import Foundation
import Capacitor
import SSZipArchive

@objc(ZipPlugin)
public class ZipPlugin: CAPPlugin {

    @objc func zip(_ call: CAPPluginCall){
        var source = call.getString("source") ?? ""
        var destination = call.getString("destination") ?? ""

        if(source.contains("_capacitor_")){
            source = source.replacingOccurrences(of: "_capacitor_", with: "file://")
        }

        if(source.contains("file://")){
            source = source.replacingOccurrences(of: "file://", with: "")
        }

        if(destination.contains("file://")){
            destination = destination.replacingOccurrences(of: "file://", with: "")
        }

        SSZipArchive.createZipFile(atPath: destination, withContentsOfDirectory: source, keepParentDirectory: true, compressionLevel: -1, password: nil, aes: true, progressHandler: nil)
    }


    @objc func unZip(_ call: CAPPluginCall){
        var source = call.getString("source") ?? ""
        var destination = call.getString("destination") ?? ""

        if(source.contains("_capacitor_")){
            source = source.replacingOccurrences(of: "_capacitor_", with: "file://")
        }

        if(source.contains("file://")){
            source = source.replacingOccurrences(of: "file://", with: "")
        }

        if(destination.contains("file://")){
            destination = destination.replacingOccurrences(of: "file://", with: "")
        }

        SSZipArchive.unzipFile(atPath: source, toDestination: destination, overwrite: true, password: nil, progressHandler: nil); 
    }
}
