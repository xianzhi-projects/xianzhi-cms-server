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

package io.xianzhi.cms.bootstrap.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) for a role.
 *
 * This class is used to transfer role-related data between different layers or systems, such as
 * from the backend to the frontend or between services. It contains the role information that
 * needs to be sent over the network, often used for creating or updating roles.
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class RoleDTO implements Serializable {
}
