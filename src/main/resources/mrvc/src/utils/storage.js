const INFO_KEY = 'user_info_a'

// 获取个人信息
export const getInfo = () => {
  const defaultObj = { userId: '', isAdmin: false }
  const result = localStorage.getItem(INFO_KEY)
  return result ? JSON.parse(result) : defaultObj
}
// 设置个人信息
export const setInfo = (obj) => {
  localStorage.setItem(INFO_KEY, JSON.stringify(obj))
}
// 删除个人信息
export const removeInfo = () => {
  localStorage.removeItem(INFO_KEY)
}