1) Install latest npm and node

https://tecadmin.net/install-nodejs-with-nvm/

2) Install Angular client tool

npm install @angular/cli

3) Create dir in your project folder and generate project
mkdir bridge
cd bridge
ng new bridge

3) type 'ng serve' to start the project and keep it running in the browser

4) install SASS css preprocessor and set sass as default
npm install node-sass sass-loader raw-loader --save
ng set defaults.styleExt scss

5) install Bootstrap 4
npm install bootstrap@4.0.0-alpha.4

UPDATING ANGULAR TO NEXT VERSION (in package.json you will see the updated versions)
npm install @angular/common@latest @angular/compiler@latest @angular/compiler-cli@latest @angular/core@latest @angular/forms@latest @angular/http@latest @angular/platform-browser@latest @angular/platform-browser-dynamic@latest @angular/platform-server@latest @angular/router@latest @angular/animations@latest typescript@latest --save


DEPLOY ON GITHUB PAGES
Angular team advises to create a docs folder in the root of your project and use this folder to deploy your app

1) npm install -g angular-cli-ghpages
2) ng build --prod --base-href "https://pdp.github.io/bridge/"
3) in Github go to Settings > Options and choose gh-branche in the section:
Source
Your GitHub Pages site is currently being built from the gh-pages branch.
4) use command ngh to publish your app (type username and password from github)

Your app should be available at https://pdp.github.io/bridge/ (replace pdp with your username)
