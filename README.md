# A full-stack playground with Vue front-end and Java webapp backend

Based on the Vue CLI guide 
[Creating a Project](https://cli.vuejs.org/guide/creating-a-project.html).
Necessary are Maven, npm and a web application server like Tomcat.
An IDE like Visual Studio Code or IntelliJ is useful.

The original project Vue CLI is expanded with a page,
[MyPage.vue](./vue-frontend/src/views/MyPage.vue),
which contains a form posting data to the webapp backend,
and receives a response from the backend and displays it.

In following sections the commands to build are all run from the project root folder.

## First time build

After cloning this repository, run:
```shell
npm --prefix ./vue-frontend clean-install
```

The output is a folder [node_modules](./vue-frontend/node_modules)
with necessary Node.js modules.

## Build for front-end development

To clean up the front-end output folder (if present),
and rebuild the webapp, run:
```shell
rm -rf ./vue-frontend/dist
mvn clean install
```

Then deploy the webapp (without the front-end) to Tomcat,
using port `8080`, and application context `/`.

Then serve the front-end from development:
```shell
npm --prefix ./vue-frontend run serve
```

Note in [vue.config.js](./vue-frontend/vue.config.js) the value `http://localhost:8080` is defined.
This is where the webapp backend is expected when serving front-end in development.

## Build for deployment

Build the front-end and webapp:
```shell
npm --prefix ./vue-frontend run build
mvn clean install
```

Then deploy the webapp (exploded) war, which now includes the front-end, to Tomcat.
