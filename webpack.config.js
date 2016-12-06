module.exports = {
  entry: "./src/main/frontend/index.ts",
  output: {
    filename: "./src/main/webapp/bundle.js"
  },
  devtool: "source-map",
  resolve: {
    extensions: ["", ".ts", ".js"]
  },
  module: {
    loaders: [
      { test: /\.ts$/, loader: "ts-loader" },
      { test: /\.html$/, loader: "vue-template-compiler-loader" }
    ]
  }
}
