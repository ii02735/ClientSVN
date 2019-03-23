package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Application {

	public static void main(String[] args) throws SVNException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] credentials = new String[3];
		System.out.println("Lien hôte :");
		credentials[0] = br.readLine();
		System.out.println("Identifiant :");
		credentials[1] = br.readLine();
		System.out.println("Mot de passe :");
		credentials[2] = br.readLine();
		System.setProperty("jsse.enableSNIExtension", "false"); //Bug dans Oracle
		DAVRepositoryFactory.setup();
		SVNRepository repository = SVNRepositoryFactory
				.create(SVNURL.parseURIEncoded(credentials[0]));
		ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(credentials[1],
				credentials[2].toCharArray());
		repository.setAuthenticationManager(authManager);

		@SuppressWarnings("rawtypes")
		Collection logEntries = repository.log(new String[] { "" }, null, 0, SVNRevision.BASE.getNumber(), true, true);
		for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
			SVNLogEntry logEntry = (SVNLogEntry) entries.next();
			System.out.println("---------------------------------------------");
			System.out.println("revision: " + logEntry.getRevision());
			System.out.println("author: " + logEntry.getAuthor());
			System.out.println("date: " + logEntry.getDate());
			System.out.println("log message: " + logEntry.getMessage());
			if (logEntry.getChangedPaths().size() > 0) {
				System.out.println();
				System.out.println("changed paths:");
				Set changedPathsSet = logEntry.getChangedPaths().keySet();

				for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
					SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get(changedPaths.next());
					System.out.println(" " + entryPath.getType() + " " + entryPath.getPath()
							+ ((entryPath.getCopyPath() != null) ? " (from " + entryPath.getCopyPath() + " revision "
									+ entryPath.getCopyRevision() + ")" : ""));
				}
			}
		}
		System.out.println("ok");

	}
}
