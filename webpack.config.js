const path=require('path')
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
      { test: /\.ts$/, loader: "ts-loader" }
    ]
  }
};