import request from '@/utils/request'

// 查询医嘱记录列表
export function listDoctorsorder(query) {
  return request({
    url: '/system/doctorsorder/list',
    method: 'get',
    params: query
  })
}

// 查询医嘱记录详细
export function getDoctorsorder(id) {
  return request({
    url: '/system/doctorsorder/' + id,
    method: 'get'
  })
}

// 新增医嘱记录
export function addDoctorsorder(data) {
  return request({
    url: '/system/doctorsorder',
    method: 'post',
    data: data
  })
}

// 修改医嘱记录
export function updateDoctorsorder(data) {
  return request({
    url: '/system/doctorsorder',
    method: 'put',
    data: data
  })
}

// 删除医嘱记录
export function delDoctorsorder(id) {
  return request({
    url: '/system/doctorsorder/' + id,
    method: 'delete'
  })
}
