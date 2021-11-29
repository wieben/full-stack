module.exports = {
    publicPath: process.env.NODE_ENV === 'production' ? '' : '', // here we can distinguish an application context / root path for production and development
    devServer: { proxy: 'http://localhost:8080' } // avoids CORS errors in development
}
