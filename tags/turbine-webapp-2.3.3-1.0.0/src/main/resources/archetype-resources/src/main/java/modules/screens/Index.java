package ${package}.modules.screens;
#*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*#

import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;

import org.apache.turbine.modules.screens.VelocitySecureScreen;

/**
 * This class provides the data required for displaying content in the
 * Velocity page. 
 */
public class Index extends VelocitySecureScreen
{
	/**
	 * This method is called by the Turbine framework when the
	 * associated Velocity template, Index.vm is requested
	 * 
	 * @param data the Turbine request data
	 * @param context the Velocity context
	 * @throws Exception a generic Exception
	 */
	@Override
	protected void doBuildTemplate(RunData data, Context context)
			throws Exception
	{
		context.put("success", "Congratulations, it worked!");
	}

	/**
	 * This method is called bythe Turbine framework to determine if
	 * the current user is allowed to use this screen. If this method
	 * returns false, the doBuildTemplate() method will not be called.
	 * If a redirect to some "access denied" page is required, do the
	 * necessary redirect here.
	 * 
	 * @param data the Turbine request data
	 * @return true if this screen may be accessed
	 * @throws Exception a generic Exception
	 */
	@Override
	protected boolean isAuthorized(RunData data) throws Exception
	{
		// use data.getACL() 
		return true;
	}
}
