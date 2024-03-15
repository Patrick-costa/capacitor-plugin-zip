export interface ZipPlugin {
  zip(options: ZipOptions): void;

  unZip(options: UnZipOptions): void;
}

export interface ZipOptions {
  source: string;
  destination: string;
  keepParent?: boolean;
}

export interface UnZipOptions {
  source: string;
  destination: string;
  overwrite?: boolean;
}