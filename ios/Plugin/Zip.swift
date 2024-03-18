import Foundation
import Capacitor
import SSZipArchive
import UIKit

public class Zip: NSObject {

    public func zip(sourcePath: String, destinationPath: String){

        var source = sourcePath
        var destination = destinationPath 

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


    public func unZip(sourcePath: String, destinationPath: String){

        var source = sourcePath
        var destination = destinationPath 

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

