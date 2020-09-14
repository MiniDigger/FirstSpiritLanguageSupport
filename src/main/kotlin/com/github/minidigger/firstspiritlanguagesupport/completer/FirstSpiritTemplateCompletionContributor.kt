package com.github.minidigger.firstspiritlanguagesupport.completer

import com.github.minidigger.firstspiritlanguagesupport.FirstSpiritTemplateLanguage
import com.github.minidigger.firstspiritlanguagesupport.psi.FirstSpiritTemplateBody
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns


class FirstSpiritTemplateCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(FirstSpiritTemplateLanguage.instance).withParent(FirstSpiritTemplateBody::class.java),
                FirstSpiritTemplateCompletionProvider()
        )

        // TODO: for media references just make a lookup to the list of firstspirit servers and show the completions of unique ids (FirstSpirit uids)
        /*
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(OutputChannelLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        fillMediaUidIntesion(resultSet);
                    }
                }
        );*/
    }

    /*
    final String host = "192.168.178.21";
    final int port = 8000;
    final String user = "Admin";
    final String password = "Admin";
    public void fillMediaUidIntesion(CompletionResultSet resultSet) {
        try {
            Connection con = ConnectionManager.getConnection(host, port, ConnectionManager.HTTP_MODE, user, password);
            con.connect();
            for (Project project : con.getProjects()) {
                MediaStoreRoot mediaStoreRoot = (MediaStoreRoot) project.getUserService().getStore(Store.Type.MEDIASTORE, true);
                Listable<Media> medias = mediaStoreRoot.getChildren(Media.class, true);
                for (Media media : medias.toList()) {
                    resultSet.addElement(LookupElementBuilder.create(media.getUid()).withTypeText(media.getDisplayName(project.getMasterLanguage()) + " - " + project.getName(), true));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (MaximumNumberOfSessionsExceededException e) {
            e.printStackTrace();
        }
    } */
}
