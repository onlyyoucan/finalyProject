import request from '@/utils/request'

// 查询Lis检验信息列表
export function listInfo(query) {
  return request({
    url: '/system/info1/list',
    method: 'get',
    params: query
  })
}

// 查询Lis检验信息详细
export function getInfo(id) {
  return request({
    url: '/system/info1/' + id,
    method: 'get'
  })
}

// 新增Lis检验信息
export function addInfo(data) {
  return request({
    url: '/system/info1',
    method: 'post',
    data: data
  })
}

// 修改Lis检验信息
export function updateInfo(data) {
  return request({
    url: '/system/info1',
    method: 'put',
    data: data
  })
}

// 删除Lis检验信息
export function delInfo(id) {
  return request({
    url: '/system/info1/' + id,
    method: 'delete'
  })
}
