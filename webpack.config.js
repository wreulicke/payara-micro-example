module.exports = {
  devServer: {
    contentBase: "src/main/webapp/",
    port: 3000,
  },
  devtool: "source-map",
  entry: "./src/main/frontend/index.ts",
  output: {
    path: "./src/main/webapp",
    filename: "bundle.js",
  },
  resolve: {
    extensions: ["", ".ts", ".js"],
  },
  module: {
    loaders: [
      {
        test: /\.ts$/,
        loader: "ts-loader",
      },
      {
        test: /\.html$/,
        loader: "vue-template-compiler-loader",
      },
    ],
  },
};
