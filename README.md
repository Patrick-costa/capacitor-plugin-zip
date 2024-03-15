# capacitor-plugin-zip

Generate Zip File

## Install

```bash
npm install capacitor-plugin-zip
npx cap sync
```

## API

<docgen-index>

* [`zip(...)`](#zip)
* [`unZip(...)`](#unzip)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### zip(...)

```typescript
zip(options: ZipOptions, progress?: Function | undefined) => void
```

| Param          | Type                                              |
| -------------- | ------------------------------------------------- |
| **`options`**  | <code><a href="#zipoptions">ZipOptions</a></code> |
| **`progress`** | <code><a href="#function">Function</a></code>     |

--------------------


### unZip(...)

```typescript
unZip(options: UnZipOptions, progress?: Function | undefined) => void
```

| Param          | Type                                                  |
| -------------- | ----------------------------------------------------- |
| **`options`**  | <code><a href="#unzipoptions">UnZipOptions</a></code> |
| **`progress`** | <code><a href="#function">Function</a></code>         |

--------------------


### Interfaces


#### ZipOptions

| Prop              | Type                 |
| ----------------- | -------------------- |
| **`source`**      | <code>string</code>  |
| **`destination`** | <code>string</code>  |
| **`keepParent`**  | <code>boolean</code> |
| **`password`**    | <code>string</code>  |


#### Function

Creates a new function.

| Prop            | Type                                          |
| --------------- | --------------------------------------------- |
| **`prototype`** | <code>any</code>                              |
| **`length`**    | <code>number</code>                           |
| **`arguments`** | <code>any</code>                              |
| **`caller`**    | <code><a href="#function">Function</a></code> |

| Method       | Signature                                                                            | Description                                                                                                                                                                                                              |
| ------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **apply**    | (this: <a href="#function">Function</a>, thisArg: any, argArray?: any) =&gt; any     | Calls the function, substituting the specified object for the this value of the function, and the specified array for the arguments of the function.                                                                     |
| **call**     | (this: <a href="#function">Function</a>, thisArg: any, ...argArray: any[]) =&gt; any | Calls a method of an object, substituting another object for the current object.                                                                                                                                         |
| **bind**     | (this: <a href="#function">Function</a>, thisArg: any, ...argArray: any[]) =&gt; any | For a given function, creates a bound function that has the same body as the original function. The this object of the bound function is associated with the specified object, and has the specified initial parameters. |
| **toString** | () =&gt; string                                                                      | Returns a string representation of a function.                                                                                                                                                                           |


#### UnZipOptions

| Prop              | Type                 |
| ----------------- | -------------------- |
| **`source`**      | <code>string</code>  |
| **`destination`** | <code>string</code>  |
| **`overwrite`**   | <code>boolean</code> |
| **`password`**    | <code>string</code>  |

</docgen-api>
