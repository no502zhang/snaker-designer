/* Copyright 2012-2013 the original author or authors.
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
package org.snaker.designer.actions;

import java.util.List;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IMenuManager;

/**
 * Form上下文菜单提供类
 * @author yuqs
 * @version 1.0
 */
public class FormContextMenuProvider extends ContextMenuProvider {
	private ActionRegistry actionRegistry;

	private List<String> actionIds;

	public FormContextMenuProvider(EditPartViewer viewer,
			List<String> actionIds, ActionRegistry registry) {
		super(viewer);
		setActionRegistry(registry);
		this.actionIds = actionIds;
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);

		ActionHelper.buildContextMenu(menu, actionIds, getActionRegistry());
	}

	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	public void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}
}
