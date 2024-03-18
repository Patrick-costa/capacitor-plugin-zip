import { WebPlugin } from '@capacitor/core';
import { ZipPlugin, ZipOptions, UnZipOptions } from './definitions';

export class ZipPluginWeb extends WebPlugin implements ZipPlugin {
constructor() {
    super({
      name: 'ZipPlugin',
      platforms: ['web', 'ios', 'android']
    });
  }

  zip(options: ZipOptions): Promise<any> {
    console.log(options);
    return Promise.resolve({});
  }
  unZip(options: UnZipOptions): Promise<any> {
    console.log(options);
    return Promise.resolve({});
  }
}

const ZipPlugin = new ZipPluginWeb();

export { ZipPlugin };