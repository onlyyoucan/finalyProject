import request from '@/utils/request'

// 查询患者费用账单列表
export function listBill(query) {
  return request({
    url: '/system/bill/list',
    method: 'get',
    params: query
  })
}

// 查询患者费用账单详细
export function getBill(id) {
  return request({
    url: '/system/bill/' + id,
    method: 'get'
  })
}

// 新增患者费用账单
export function addBill(data) {
  return request({
    url: '/system/bill',
  method: 'post',
  data: data
})
}

// 修改患者费用账单
export function updateBill(data) {
  return request({
    url: '/system/bill',
    method: 'put',
    data: data
  })
}

// 删除患者费用账单
export function delBill(id) {
  return request({
    url: '/system/bill/' + id,
    method: 'delete'
  })
}
