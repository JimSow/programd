/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.server.jettyinterface;

import org.aitools.programd.Core;

import org.mortbay.http.HttpContext;
import org.mortbay.jetty.Server;

public class ProgramDAwareJettyServer extends Server
{
    public ProgramDAwareJettyServer(Core core)
    {
        super();
        HttpContext[] contexts = this.getContexts();
        for (int index = 0; index < contexts.length; index++)
        {
            contexts[index].setAttribute("core", core);
        }
    }
}