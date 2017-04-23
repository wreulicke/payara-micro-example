var path = require('path')
module.exports = {
  devServer: {
    contentBase: "src/main/webapp/",
    port: 3000,
  },
  devtool: "source-map",
  entry: path.resolve("./src/main/frontend/index.ts"),
  output: {
    path: path.resolve("./src/main/webapp"),
    filename: "bundle.js",
  },
  resolve: {
    extensions: [".ts", ".js"],
  },
  module: {
    rules: [
      {
        test: /\.ts$/,
        use: "ts-loader",
      },
      {
        test: /\.html$/,
        use: "vue-template-compiler-loader",
      },
    ],
  },
};
