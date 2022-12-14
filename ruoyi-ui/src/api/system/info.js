import request from '@/utils/request'

// 查询药品列表
export function listInfo(query) {
  return request({
    url: '/system/pharmacy/info/list',
    method: 'get',
    params: query
  })
}

// 查询药品详细
export function getInfo(id) {
  return request({
    url: '/system/pharmacy/info/' + id,
    method: 'get'
  })
}

// 新增药品
export function addInfo(data) {
  return request({
    url: '/system/pharmacy/info',
    method: 'post',
    data: data
  })
}

// 修改药品
export function updateInfo(data) {
  return request({
    url: '/system/pharmacy/info',
    method: 'put',
    data: data
  })
}

// 删除药品
export function delInfo(id) {
  return request({
    url: '/system/pharmacy/info/' + id,
    method: 'delete'
  })
}
