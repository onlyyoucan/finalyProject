import request from '@/utils/request'

// 查询病房记录列表
export function listSickroom(query) {
  return request({
    url: '/system/sickroom/list',
    method: 'get',
    params: query
  })
}

// 查询病房记录详细
export function getSickroom(id) {
  return request({
    url: '/system/sickroom/' + id,
    method: 'get'
  })
}

// 新增病房记录
export function addSickroom(data) {
  return request({
    url: '/system/sickroom',
    method: 'post',
    data: data
  })
}

// 修改病房记录
export function updateSickroom(data) {
  return request({
    url: '/system/sickroom',
    method: 'put',
    data: data
  })
}

// 删除病房记录
export function delSickroom(id) {
  return request({
    url: '/system/sickroom/' + id,
    method: 'delete'
  })
}
