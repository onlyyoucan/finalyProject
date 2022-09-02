import request from '@/utils/request'

// 查询候诊室列表
export function listWait(query) {
  return request({
    url: '/system/wait/list',
    method: 'get',
    params: query
  })
}

// 查询候诊室详细
export function getWait(id) {
  return request({
    url: '/system/wait/' + id,
    method: 'get'
  })
}

// 新增候诊室
export function addWait(data) {
  return request({
    url: '/system/wait',
    method: 'post',
    data: data
  })
}

// 修改候诊室
export function updateWait(data) {
  return request({
    url: '/system/wait',
    method: 'put',
    data: data
  })
}

// 删除候诊室
export function delWait(id) {
  return request({
    url: '/system/wait/' + id,
    method: 'delete'
  })
}
