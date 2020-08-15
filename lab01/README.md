This is the hello-world application from Expo

- <https://expo.io/learn> (cf. <https://reactnative.dev/docs/environment-setup>)
- Cf. videos 1&ndash;3 from the 
[React Native Tutorial for Beginners](https://www.youtube.com/playlist?list=PL4cUxeGkcC9ixPU-QkScoRBVxtPPzVjrQ)

The code in the 
[tutorial codebase](https://github.com/iamshaunjp/react-native-tutorial) 
doesn't run with current versions of Expo/NodeJS. The "Unterminated character 
class" and versioning errors can be fixed by:
1. Deleting:
    - `node_modules/`
    - `package-lock.json`
2. Editing:
    - `package.json` to match expo, react & babel versions in 
        dependencies/devDependencies to match those from myNewProject.
        - For gamezone, also run `npm install react-native-screens@~2.9.0`.                    
    - Remove the sdkVersion line from `app.json`.
3. Rerunning:
    ```
    npm install
    expo start
    ```
- References 
    - <https://github.com/expo/expo-cli/issues/1074>