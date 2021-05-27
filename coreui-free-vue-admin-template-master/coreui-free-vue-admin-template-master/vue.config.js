module.exports = {
  lintOnSave: false,
  runtimeCompiler: true,
  configureWebpack: {
    //Necessary to run npm link https://webpack.js.org/configuration/resolve/#resolve-symlinks
    resolve: {
       symlinks: false
    }
  },
 // https://cli.vuejs.org/config/#devserver-proxy
 devServer: {
  port: 3001,
  proxy: {
      '/api': {
          target: 'http://localhost:4000',
          ws: true,
          changeOrigin: true
      }
  }
},
  transpileDependencies: [
    '@coreui/utils',
    '@coreui/vue'
  ]
}

// module.exports = {
//   // https://cli.vuejs.org/config/#devserver-proxy
//   devServer: {
//       port: 3000,
//       proxy: {
//           '/api': {
//               target: 'http://localhost:8080',
//               ws: true,
//               changeOrigin: true
//           }
//       }
//   }
// }