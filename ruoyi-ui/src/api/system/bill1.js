import request from '@/utils/request'

// 查询医院烂账记录列表
export function listBill(query) {
  return request({
    url: '/system/deadbill/list',
    method: 'get',
    params: query
  })
}

// 查询医院烂账记录详细
export function getBill(id) {
  return request({
    url: '/system/deadbill/' + id,
    method: 'get'
  })
}

// 新增医院烂账记录
export function addBill(data) {
  return request({
    url: '/system/deadbill',
    method: 'post',
    data: data
  })
}

// 修改医院烂账记录
export function updateBill(data) {
  return request({
    url: '/system/deadbill',
    method: 'put',
    data: data
  })
}

// 删除医院烂账记录
export function delBill(id) {
  return request({
    url: '/system/deadbill/' + id,
    method: 'delete'
  })
}
