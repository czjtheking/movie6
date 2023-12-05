import axios from 'axios'
import { Message } from 'element-ui';
// import { Loading } from 'element-ui';


// 创建axios实例：对创建出来的实例自定义配置
const instance = axios.create({
  baseURL: 'http://localhost/',
  // 这里写的是接口根目录(后面要修改)
  timeout: 5000,
});

<<<<<<< HEAD
// let loadingInstance÷
=======
<<<<<<< HEAD
// let loadingInstance÷
=======
// let loadingInstance
>>>>>>> da91b1bed462688ee57359e6c7285bf06f953d4a
>>>>>>> 2889f087f9a19bf76b610a71594a2819fce66368
// 自定义配置 - 请求/响应拦截器
// 添加请求拦截器
instance.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  //开启loaging
  // loadingInstance = Loading.service(); //暂时注释
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (response) {
  // 2xx 范围内的状态码都会触发该函数
  // 对响应数据做点什么

  // loadingInstance.close(); //暂时注释


  const res = response.data
  console.log(response)
  if (res.code != 200) {
    // 给提示
    Message.error({
      message: res.msg,
      duration: 1000,
      offset: 75
    });
    //返回错误
    return Promise.reject(res.msg)
  }
  return res;
}, function (error) {
  // 超出 2xx 范围的状态码都会触发该函数。
  // 对响应错误做点什么
  return Promise.reject(error);
});

// 导出
export default instance
