import request from '@/utils/request'

// 查询床位记录列表
export function listBed(query) {
  return request({
    url: '/system/bed/list',
    method: 'get',
    params: query
  })
}

// 查询床位记录详细
export function getBed(id) {
  return request({
    url: '/system/bed/' + id,
    method: 'get'
  })
}

// 新增床位记录
export function addBed(data) {
  return request({
    url: '/system/bed',
    method: 'post',
    data: data
  })
}

// 修改床位记录
export function updateBed(data) {
  return request({
    url: '/system/bed',
    method: 'put',
    data: data
  })
}

// 删除床位记录
export function delBed(id) {
  return request({
    url: '/system/bed/' + id,
    method: 'delete'
  })
}
