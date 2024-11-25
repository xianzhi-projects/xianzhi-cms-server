/*
 * Copyright 2024 XianZhi Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
const columns = [
  {
    title: '模板名称',
    dataIndex: 'templateName',
  },
  {
    title: '接口地址',
    dataIndex: 'interfaceUrl',
  },

  {
    title: '模板描述',
    dataIndex: 'templateDesc',
  },
  {
    title: '操作类型',
    dataIndex: 'operationType',
  },
  {
    title: '是否启用',
    dataIndex: 'enableFlag',
  },
  {
    title: '新增时间',
    dataIndex: 'createAt',
  },
  {
    title: '操作',
    key: 'operation',
  },
]


export {columns}

